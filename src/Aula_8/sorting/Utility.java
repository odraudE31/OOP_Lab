package sorting;

public class Utility {

    public static Integer[] int2Integer(int[] arr) {
        Integer[] result = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static Double[] double2Double(double[] arr) {
        Double[] result = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static Character[] char2Character(char[] arr) {
        Character[] result = new Character[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    // Just to keep the pattern
    public static String[] string2String(String[] arr) {
        return arr;
    }

    // Every element is of the same type? Couldnt use it, couldnt declare an array as an generyc Comparable
    public static boolean isHomogeneous(Object[] arr) {
        if (arr == null || arr.length == 0) return true;
        Class<?> firstType = arr[0].getClass();
        for (Object obj : arr) {
            if (obj != null && obj.getClass() != firstType) {
                return false;
            }
        }
        return true;
    }
}
