/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.test.model.types.suport;

import java.util.Collection;

import org.jboss.model.types.CompositeMetaType;
import org.jboss.model.values.CompositeValue;
import org.jboss.model.values.MetaValue;

/**
 * MockCompositeValue.
 *
 * @author <a href="adrian@jboss.com">Adrian Brock</a>
 */
public class MockCompositeValue extends MockMetaValue implements CompositeValue {

    /** The serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * Create a new MockCompositeValue.
     *
     * @param metaType the meta type
     */
    public MockCompositeValue(CompositeMetaType metaType) {
        super(metaType);
    }

    public CompositeMetaType getMetaType() {
        return (CompositeMetaType) super.getMetaType();
    }

    public boolean containsKey(String key) {
        throw new IllegalStateException("containsKey");
    }

    public boolean containsValue(MetaValue value) {
        throw new IllegalStateException("containsValue");
    }

    public MetaValue get(String key) {
        throw new IllegalStateException("get");
    }

    public MetaValue[] getAll(String[] keys) {
        throw new IllegalStateException("getAll");
    }

    public Collection<MetaValue> values() {
        throw new IllegalStateException("values");
    }

    public void set(String key, MetaValue metaValue) {
        throw new IllegalStateException("set");
    }
}
