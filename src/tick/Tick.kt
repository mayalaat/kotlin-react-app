package tick

import react.*
import react.dom.div
import kotlin.browser.window

interface TickState : RState {
    var seconds: Int
}

class Timer : RComponent<RProps, TickState>() {

    var intervalId: Int = 0

    override fun TickState.init() {
        seconds = 0
    }

    override fun componentDidMount() {
        intervalId = window.setInterval(tick(), 1000)
    }

    override fun componentWillMount() {
        window.clearInterval(intervalId)
    }

    fun tick() = {
        setState { seconds += 1 }
    }

    override fun RBuilder.render() {
        div { +"Secondos: ${state.seconds}" }
    }
}

fun RBuilder.tick() = child(Timer::class) {
}