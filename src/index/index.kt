package index

import react.dom.render
import tick.tick
import kotlin.browser.document

fun main(args: Array<String>) {
    render(document.getElementById("root")) {
        //helloMessage()
        tick()
    }
}
