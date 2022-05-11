package com.athena.security;


import com.google.common.collect.Sets;
import com.athena.security.ApplicationUserPermission.*;
import java.util.Set;

import static com.athena.security.ApplicationUserPermission.*;


public enum ApplicationUserRole {

    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(USER_PII_READ,
            USER_PII_WRITE,
            USER_GOAL_READ,
            USER_GOAL_WRITE,
            USER_MILESTONE_READ,
            USER_MILESTONE_WRITE,
            USER_OBJECTIVE_READ,
            USER_OBJECTIVE_WRITE,
            USER_TASK_READ,
            USER_TASK_WRITE,
            USER_CALENDAR_READ,
            USER_CALENDAR_WRITE,
            ADMINISTRATOR));

    private final Set<ApplicationUserPermission> permissions;


    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
