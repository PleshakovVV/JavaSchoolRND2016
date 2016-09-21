/**
 * Created by Master on 13.08.2016.
 */
public interface TwoParameterValidatable<V, T1, T2> {
    boolean isValidate(V v, T1 t1, T2 t2);
}
