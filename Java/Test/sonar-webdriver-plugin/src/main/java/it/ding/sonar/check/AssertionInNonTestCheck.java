package it.ding.sonar.check;

import static it.ding.sonar.data.CommonData.ASSERTIONS_IN_NON_TEST_CHECK_KEY;
import static it.ding.sonar.util.CommonUtil.methodInvocationIsAssertion;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;

@Rule(key = ASSERTIONS_IN_NON_TEST_CHECK_KEY)
public class AssertionInNonTestCheck extends BaseNonTestCheck {

    @Override
    public void visitMethodInvocation(MethodInvocationTree tree) {
        JavaFileScannerContext context = getContext();

        if (methodInvocationIsAssertion(tree)) {
            context.reportIssue(this, tree, "Should not use assertions in non-test classes.");
        }
    }
}
