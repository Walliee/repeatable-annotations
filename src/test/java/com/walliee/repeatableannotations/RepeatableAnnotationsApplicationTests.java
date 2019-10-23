package com.walliee.repeatableannotations;

import java.lang.reflect.Method;

import org.junit.Test;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;

import static java.util.Collections.singletonMap;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RepeatableAnnotationsApplicationTests {

	@Test
	public void findsRepeatedAnnotations() throws NoSuchMethodException {
		Method method = MyObject.class.getMethod("someMethod");
		Method mostSpecificMethod = ClassUtils.getMostSpecificMethod(method, MyObject.class);
		Roles annotation = AnnotationUtils.findAnnotation(mostSpecificMethod, Roles.class);

		assertNotNull(annotation);
		assertEquals(2, annotation.value().length);
		Role role_a = AnnotationUtils.synthesizeAnnotation(singletonMap("value", "role_a"), Role.class, null);
		Role role_b = AnnotationUtils.synthesizeAnnotation(singletonMap("value", "role_b"), Role.class, null);
		Role[] roles = {role_a, role_b};
		assertArrayEquals(roles, annotation.value());
	}


	static class MyObject {
		@MyCustomRole
		public void someMethod() {

		}
	}
}
