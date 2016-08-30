package homeWork14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Master on 31.07.2016.
 */
public class ProxyUtils {

    static private class InvocationHandlerImpl<T> implements InvocationHandler {

        private T t;

        private Map<MethodArgs, LockAndObject> cache = new HashMap<>();
        private Lock cacheLock = new ReentrantLock();

        public InvocationHandlerImpl(T t) {
            this.t = t;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if (method.isAnnotationPresent(Cache.class)) {

                MethodArgs methodArgs = new MethodArgs(method, args);
                cacheLock.lock();
                System.out.println(Thread.currentThread().getName() + ": Cache locked");
                if (cache.containsKey(methodArgs)) {
                    Lock elementLock = cache.get(methodArgs).getLock();
                    cacheLock.unlock();
                    System.out.println(Thread.currentThread().getName() + ": Cache unlocked");
                    elementLock.lock();
                    System.out.println(Thread.currentThread().getName() + ": Element locked");
                    Object value = cache.get(methodArgs).getObject();
                    elementLock.unlock();
                    System.out.println(Thread.currentThread().getName() + ": Element unlocked");
                    System.out.println("Return from cache. Method: " + method.getName());
                    return value;
                } else {
                    LockAndObject lockAndObject = new LockAndObject(new ReentrantLock());
                    cache.put(methodArgs, lockAndObject);
                    lockAndObject.getLock().lock();
                    System.out.println(Thread.currentThread().getName() + ": Element locked");
                    cacheLock.unlock();
                    System.out.println(Thread.currentThread().getName() + ": Cache unlocked");
                    System.out.println("Translation invoke to method. Method: " + method.getName());
                    Object result = method.invoke(t, args);
                    System.out.println("Save to cache. Method: " + method.getName());
                    cache.get(methodArgs).setObject(result);
                    lockAndObject.getLock().unlock();
                    System.out.println(Thread.currentThread().getName() + ": Element unlocked");
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

    private static class LockAndObject {
        private final Lock lock;
        private Object object;

        public LockAndObject(Lock lock) {
            this.lock = lock;
        }

        public Lock getLock() {
            return lock;
        }

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }
    }

    public static <T> T makeCached(T t) {
        Object result = Proxy.newProxyInstance(t.getClass().getClassLoader(),
                t.getClass().getInterfaces(), new InvocationHandlerImpl<>(t));
        return (T)result;
    }
}
