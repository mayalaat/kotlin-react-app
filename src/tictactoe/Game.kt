package tictactoe

import kotlinx.html.js.onClickFunction
import react.*
import react.dom.button
import react.dom.div
import react.dom.ol

/*interface SquareState : RState {
    var value: String
}*/

interface SquareProps : RProps {
    var valueProp: String?
    var onClick: () -> Unit
}

class Square : RComponent<SquareProps, RState>() {

    override fun RBuilder.render() {
        button(classes = "square") {
            attrs {
                onClickFunction = {
                    println("click")
                    props.onClick()
                }
            }
            +(props.valueProp ?: "")
        }
    }

}

fun RBuilder.square(value: String?, onClick: () -> Unit) = child(Square::class) {
    attrs.valueProp = value
    attrs.onClick = onClick
}

interface BoardState : RState {
    var squares: Array<String?>
}

class Board : RComponent<RProps, BoardState>() {
    override fun BoardState.init() {
        squares = arrayOfNulls<String>(9)
    }

    fun handleClick(i: Int): () -> Unit = {
        println("Handleclic")
        val sq = state.squares.copyOf()
        sq[i] = "X"
        setState {
            squares = sq
        }
    }

    fun RBuilder.renderSquare(i: Int) {
        square(state.squares[i], handleClick(i))
    }

    override fun RBuilder.render() {
        val status = "Next player: X"
        div {
            div("status") {
                +status
            }
            div(classes = "board-row") {
                renderSquare(0)
                renderSquare(1)
                renderSquare(2)
            }
            div(classes = "board-row") {
                renderSquare(3)
                renderSquare(4)
                renderSquare(5)
            }
            div(classes = "board-row") {
                renderSquare(6)
                renderSquare(7)
                renderSquare(8)
            }
        }
    }
}

fun RBuilder.board() = child(Board::class) {}

class Game : RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        div(classes = "game") {
            div(classes = "game-board") {
                board()
            }
            div(classes = "game-info") {
                div {
                    //TODO status}
                    ol {
                        //TODO }
                    }
                }

            }
        }
    }
}

fun RBuilder.ticTacToe() = child(Game::class) {}