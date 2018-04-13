package hello

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

interface Name : RProps {
    var name: String
}

class HelloMessage : RComponent<Name, RState>() {

    override fun RBuilder.render() {
        div { +"Hello ${props.name}" }
    }
}

fun RBuilder.helloMessage(name: String = "Alejandro Ayala") = child(HelloMessage::class) {
    attrs.name = name
}