package index

import hello.helloMessage
import react.dom.render
import kotlin.browser.document

fun main(args: Array<String>) {
    render(document.getElementById("root")) {
        helloMessage()
    }
}
