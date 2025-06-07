package org.apache.tinkerpop.gremlin.process.traversal.step.map;

import org.apache.tinkerpop.gremlin.process.traversal.Traversal;
import org.apache.tinkerpop.gremlin.process.traversal.Traverser;
import org.apache.tinkerpop.gremlin.process.traversal.traverser.TraverserRequirement;
import org.apache.tinkerpop.gremlin.structure.util.StringFactory;

import java.util.Collections;
import java.util.Set;

/**
 * Reference implementation for boolean parsing step.
 */
public final class AsBoolStep<S> extends ScalarMapStep<S, Boolean> {

    public AsBoolStep(final Traversal.Admin traversal) {
        super(traversal);
    }

    @Override
    protected Boolean map(final Traverser.Admin<S> traverser) {
        final Object object = traverser.get();
        if (object == null) return false;
        if (object instanceof Boolean) return (Boolean) object;
        if (object instanceof Number) {
            final double d = ((Number) object).doubleValue();
            if (Double.isNaN(d) || d == 0d) return false;
            return d != 0d;
        }
        if (object instanceof String) {
            final String str = (String) object;
            if (str.equalsIgnoreCase("true")) return true;
            if (str.equalsIgnoreCase("false")) return false;
            throw new IllegalArgumentException("Can't parse " + object + " as Boolean.");
        }
        throw new IllegalArgumentException("Can't parse " + object.getClass().getName() + " as Boolean.");
    }

    @Override
    public Set<TraverserRequirement> getRequirements() {
        return Collections.singleton(TraverserRequirement.OBJECT);
    }

    @Override
    public String toString() {
        return StringFactory.stepString(this);
    }
}
