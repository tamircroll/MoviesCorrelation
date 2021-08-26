package View

import java.awt.{Dimension, Toolkit}
import scala.swing._
import _root_.model.MoviesDataEngine

class MainView(moviesData : MoviesDataEngine, screenSize : Option[Dimension] = None)
{
    val screenDimension : Dimension = screenSize.getOrElse(Toolkit.getDefaultToolkit.getScreenSize)
    
    new Frame
    {
        preferredSize = new Dimension(screenDimension.width, screenDimension.height)
        title = "Movie correlator"
        
        contents = new MainPane(moviesData)
        
        pack()
        centerOnScreen()
        open()
    }
}


