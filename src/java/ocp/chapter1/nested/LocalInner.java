package java.ocp.chapter1.nested;

public class LocalInner {
    private static final int value1 = 1;
    private final int value2 = 2;
    private int value3 = 3;

    public void createLocalInnerClass() {
        final int local1 = 1;
        int local2 = 2;
        local2 = 3;
        value3 = 4;

        // public InnerClass { // NO ACCESS MODIFIER ALLOWED
        // static InnerClass { // STATIC NOT ALLOWED
        // final InnerClass { // FINAL IS OK

        class InnerClass { // FINAL OK
            public boolean canAcessFields() {
                int tmp1 = value1;
                int tmp2 = value2;
                int tmp3 = value3;

                //Just for the hell of it try accessing value1 in a static way
                int tmp4 = LocalInner.value1;

                return true;
            }

            public boolean canAccessLocalVariables() {
                int tmp1 = local1; // OK
            //  int tmp2 = local2;  // NOT OK

                return false;
            }

            protected boolean canCreateProtectedMethods() {
                return true;
            }

            /* public static boolean canCreateStaticMethods() {
                return false;
            } */

            public final boolean canCreateFinalMethods() {
                return true;
            }
        }

        // Can also extend inner classes if not final
        final class InnerClass2 extends InnerClass {
            private boolean canCreatePrivateMethods() {
                return true;
            }
        }

        InnerClass2 innerClass = new InnerClass2();
        boolean canAccessPrivateMethods = innerClass.canCreatePrivateMethods();
    }
}
