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

package org.jboss.model.entity.info.builder;

import java.util.ArrayList;
import java.util.List;

import org.jboss.model.entity.info.ManagedResourceAdderInfo;
import org.jboss.model.entity.info.RestartPolicy;
import org.jboss.model.types.Named;

/**
 * @author Emanuel Muckenhuber
 */
public class EntityAdderInfoBuilder extends AbstractEntityFeatureBuilder<ManagedResourceAdderInfo> {

    private RestartPolicy restartPolicy = RestartPolicy.UNKNOWN;
    private List<EntityParameterInfoBuilder> signatureBulders = new ArrayList<EntityParameterInfoBuilder>();

    EntityAdderInfoBuilder(String name) {
        super(name);
    }

    EntityAdderInfoBuilder(String name, String description) {
        super(name, description);
    }

    public EntityAdderInfoBuilder setRestartPolicy(RestartPolicy restartPolicy) {
        if(restartPolicy == null) {
            throw new IllegalArgumentException("null restart policy");
        }
        this.restartPolicy = restartPolicy;
        return this;
    }

    public EntityParameterInfoBuilder addParamter(final String name) {
        final EntityParameterInfoBuilder builder = new EntityParameterInfoBuilder(name);
        signatureBulders.add(builder);
        return builder;
    }

    public EntityParameterInfoBuilder addParamter(final String name, final String description) {
        final EntityParameterInfoBuilder builder = new EntityParameterInfoBuilder(name, description);
        signatureBulders.add(builder);
        return builder;
    }

    public EntityParameterInfoBuilder addParamter(final Named name) {
        return addParamter(getName(name));
    }

    public EntityParameterInfoBuilder addParamter(final Named name, final String description) {
        return addParamter(getName(name), description);
    }

    public void checkValid() {
        //
    }

    protected ManagedResourceAdderInfo create() {
        checkValid();
        return new ManagedResourceAdderInfo(name, description, createSignature(signatureBulders), restartPolicy, null);
    }

}
