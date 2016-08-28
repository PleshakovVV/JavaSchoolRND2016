package homeWork14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Master on 31.07.2016.
 */
public class ProxyUtils {

    static private class InvocationHandlerImpl<T> implements InvocationHandler {

        private T t;

        private Map<MethodArgs, Object> cache = new HashMap<>();

        public InvocationHandlerImpl(T t) {
            this.t = t;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if (method.isAnnotationPresent(Cache.class)) {

                MethodArgs methodArgs = new MethodArgs(method, args);
                if (cache.containsKey(methodArgs)) {
                    System.out.println("Return from cache. Method: " + method.getName());
                    return cache.get(methodArgs);
                } else {
                    System.out.println("Translation invoke to method. Method: " + method.getName());
                    Object result = method.invoke(t, args);
                    System.out.println("Save to cache. Method: " + method.getName());
                    cache.put(methodArgs, result);
                    System.out.println("Return from cache. Method: " + method.getName());
                    return result;
                }
            }
            else {
                System.out.println("Return from invoke - method not marked. Method: " + method.getName());
                return method.invoke(t, args);
            }
        }
    }

    private static class MethodArgs {
        private Method method;
        private Object[] args;

        public MethodArgs(Method method, Object[] args) {
            this.method = method;
            this.args = args;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MethodArgs that = (MethodArgs) o;

            if (!method.equals(that.method)) return false;
            // Probably incorrect - comparing Object[] arrays with Arrays.equals
            return Arrays.equals(args, that.args);

        }

        @Override
        public int hashCode() {
            int result = method.hashCode();
            result = 31 * result + Arrays.hashCode(args);
            return result;
        }
    }

    public static <T> T makeCached(T t) {
        Object result = Proxy.newProxyInstance(t.getClass().getClassLoader(),
                t.getClass().getInterfaces(), new InvocationHandlerImpl<>(t));
        return (T)result;
    }
}
