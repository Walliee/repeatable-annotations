package com.walliee.repeatableannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Role("role_a")
@Role("role_b")
public @interface MyCustomRole {
}
