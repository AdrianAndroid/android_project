package com.flannery.library;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(CLASS)
@Target({CONSTRUCTOR, METHOD, FIELD, TYPE})
@Repeatable(UnsupportedAppUsage.Container.class)
public @interface UnsupportedAppUsage {

    /**
     * Associates a bug tracking the work to add a public alternative to this API. Optional.
     *
     * @return ID of the associated tracking bug
     */
    long trackingBug() default 0;

    int maxTargetSdk() default Integer.MAX_VALUE;

    /**
     * The signature of an implicit (not present in the source) member that forms part of the
     * hiddenapi.
     *
     * <p>Allows access to non-SDK API elements that are not represented in the input source to be
     * managed.
     *
     * <p>This must only be used when applying the annotation to a type, using it in any other
     * situation is an error.
     *
     * @return A dex API signature.
     */
    String implicitMember() default "";

    /**
     * Public API alternatives to this API.
     *
     * <p>If non-empty, the string must be a description of the public API alternative(s) to this
     * API. The explanation must contain at least one Javadoc link tag to public API methods or
     * fields. e.g.:
     * {@literal @UnsupportedAppUsage(publicAlternatives="Use {@link foo.bar.Baz#bat()} instead.")}
     *
     * <p>Any elements that can be deduced can be omitted, e.g.:
     * <ul>
     *      <li>
     *          the class, if it's the same as for the annotated element.
     *      </li>
     *      <li>
     *          the package name, if it's the same as for the annotated element.
     *      </li>
     *      <li>
     *          the method parameters, if there is only one method with that name in the given
     *          package and class.
     *      </li>
     * </ul>
     * @return A Javadoc-formatted string.
     */
    @SuppressWarnings("JavadocReference")
    String publicAlternatives() default "";

    /**
     * Container for {@link UnsupportedAppUsage} that allows it to be applied repeatedly to types.
     */
    @Retention(CLASS)
    @Target(TYPE)
    @interface Container {
        UnsupportedAppUsage[] value();
    }

    /**
     * Internal usage only.
     *
     * Override the default source position when generating an index of the annotations.
     *
     * <p>This is intended for use by tools that generate java source code, to point to the
     * original source position of the annotation, rather than the position within the generated
     * code. It should never be set manually.
     *
     * <p>The format of the value is "path/to/file:startline:startcol:endline:endcol" indicating
     * the position of the annotation itself.
     */
    String overrideSourcePosition() default "";

    /**
     * Internal usage only.
     *
     * For debug use only. The expected dex signature to be generated for this API, used to verify
     * parts of the build process.
     *
     * @return A dex API signature.
     */
    String expectedSignature() default "";
}