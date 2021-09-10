package visibilitymodifiers

import visibilitymodifiers.internal.InternalClass
import visibilitymodifiers.internal.InternalWithConstructorClass

class PublicClass {

    val internalClass = InternalClass()

    val internalWithConstructorClass = InternalWithConstructorClass()

    init {

        internalWithConstructorClass.name
    }
}