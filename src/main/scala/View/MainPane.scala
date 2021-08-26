package View

import scala.swing._
import _root_.model.MoviesDataEngine
import scala.swing.event._

class MainPane(moviesData : MoviesDataEngine) extends FlowPanel
{
    contents += new Label("Launch rainbows:")
    {
        border = Swing.EmptyBorder(4)
        listenTo(mouse.clicks)
        reactions +=
        {
            case _ : event.MouseClicked => println(s"TAMIR: CLICkED ! ! !")
        }
    }
    
    contents += new Button("Click me")
    {
        reactions +=
        {
            case event.ButtonClicked(_) => println("All the colours!")
        }
    }
    
    def squareGeometry : (Int, Int, Int, Int) =
    {
        val d = size
        val squareSide = d.height min d.width
        val x0 = (d.width - squareSide) / 2
        val y0 = (d.height - squareSide) / 2
        (squareSide, x0, y0, squareSide / 3)
    }
    
    listenTo(keys)
    reactions +=
    {
        case MouseClicked(_, p, _, _, _) => mouseClick(p.x, p.y)
        case KeyTyped(_, c, _, _) =>
            if('1' <= c && c <= '9')
            {
                val idx = c - '1'
                publish(TicTacToeEvent(idx % 3, idx / 3))
            }
    }
    
    private def mouseClick(x : Int, y : Int)
    {
        val (squareSide, x0, y0, wid) = squareGeometry
        if(x0 <= x && x < x0 + squareSide &&
           y0 <= y && y < y0 + squareSide)
        {
            val col = (x - x0) / wid
            val row = (y - y0) / wid
            publish(TicTacToeEvent(col, row))
        }
    }
}

case class TicTacToeEvent(x : Int, y : Int) extends Event
