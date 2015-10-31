
import java.awt.Image;
import java.awt.Toolkit;

public class Barrier extends SquareSprite
{	
	public Barrier(int xCoordinate, int yCoordinate)
	{
		spriteImage = BarrierSpriteImageSource.rawImage;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
}


class BarrierSpriteImageSource
{
	static Image rawImage;
	
	static void loadImage() throws InterruptedException
	{
		rawImage = FreakyBombFreak.toolkit.getImage("Barrier Sprite.png");
		FreakyBombFreak.mediaTracker.addImage(rawImage, 0);
		FreakyBombFreak.mediaTracker.waitForAll();
	}
}
