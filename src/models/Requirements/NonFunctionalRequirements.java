package models.Requirements;

import models.ObservableEntryHolder;

/**
 * Created by Michi on 23.04.2017.
 */
class NonFunctionalRequirements extends ObservableEntryHolder<I_NonFunctionalRequirementEntry> implements I_NonFunctionalRequirements {
    @Override
    public I_NonFunctionalRequirementEntry createEntry() {
        return new NonFunctionalRequirementEntry();
    }
}
