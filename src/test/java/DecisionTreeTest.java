import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class DecisionTreeTest {

    @Test // Test tree initialization
    public void testTreeInitialization() {
        DecisionTree tree = new DecisionTree();

        assertNotNull(tree, "DecisionTree should be initialized successfully");
    }
}
