package com.example.demo.security;

import com.google.common.collect.Sets;

import java.util.Set;

public enum ApplicationUserRoles {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(ApplicationUserPermissions.COURSE_READ,ApplicationUserPermissions.COURSE_WRITE,ApplicationUserPermissions.STUDENT_READ,ApplicationUserPermissions.STUDENT_WRITE));

    private final Set<ApplicationUserPermissions> permissions;

    ApplicationUserRoles(Set<ApplicationUserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermissions> getPermissions(){
        return permissions;
    }
}
