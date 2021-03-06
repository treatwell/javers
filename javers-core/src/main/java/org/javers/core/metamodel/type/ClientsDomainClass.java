package org.javers.core.metamodel.type;

import static org.javers.common.validation.Validate.argumentIsNotNull;

/**
 * Reflects one class in a client's domain model.
 *
 * @author bartosz walacik
 */
abstract class ClientsDomainClass {
    private final Class clientsClass;

    ClientsDomainClass(Class clientsClass) {
        argumentIsNotNull(clientsClass);
        this.clientsClass = clientsClass;
    }

    @Deprecated
    Class getClientsClass() {
        return clientsClass;
    }

    /**
     * type name, clientsClass.name by default
     *
     * @deprecated moved to JaversType
     */
    @Deprecated
    String getName() {
        return clientsClass.getName();
    }

    /**
     * 'Entity', 'ValueObject' or 'Value'
     */
    String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof ClientsDomainClass)) {
            return false;
        }

        ClientsDomainClass that = (ClientsDomainClass) o;
        return clientsClass.equals(that.clientsClass);
    }

    @Override
    public int hashCode() {
        return clientsClass.hashCode();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"("+getClientsClass().getSimpleName()+")";
    }
}
