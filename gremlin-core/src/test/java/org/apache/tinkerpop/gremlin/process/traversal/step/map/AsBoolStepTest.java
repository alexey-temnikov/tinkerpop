package org.apache.tinkerpop.gremlin.process.traversal.step.map;

import org.apache.tinkerpop.gremlin.process.traversal.Traversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__;
import org.apache.tinkerpop.gremlin.process.traversal.step.StepTest;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AsBoolStepTest extends StepTest {

    @Override
    protected List<Traversal> getTraversals() {
        return Collections.singletonList(__.asBool());
    }

    @Test
    public void shouldParseBoolean() {
        assertEquals(true, __.__(1).asBool().next());
        assertEquals(false, __.__(0).asBool().next());
        assertEquals(true, __.__(3.14).asBool().next());
        assertEquals(false, __.__(Double.NaN).asBool().next());
        assertEquals(false, __.__(null).asBool().next());
        assertEquals(true, __.__("TRUE").asBool().next());
        assertEquals(false, __.__("false").asBool().next());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowOnInvalidString() {
        __.__("hello").asBool().next();
    }
}
