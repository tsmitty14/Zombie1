package zombie;

import java.awt.Color;
import java.util.Random;


public class Human {
	private ZombieModel Mod;
	private int width;
	private int height;
	private int x = 0;
	private Direction direction;
	private Random randnum = new Random();
	
	public Human(ZombieModel model)
	{
		Mod = model;
		getParams();
		x = 0;
		while(true)
		{
			if(Mod.getColor(width, height) == Color.BLACK)
				break;
			else getParams();
		}
			Mod.setColor(width, height, Color.WHITE);
			direction = Direction.NORTH;
	}
	public void getParams()
	{
		width = randnum.nextInt(Mod.getWidth());
		height = randnum.nextInt(Mod.getHeight());
	}
	public void setDirection(Direction x) {
		direction = x;
	}
	public void update()
	{
		if(direction == Direction.NORTH && height > 0  && Mod.getColor(width, height -1) == Color.BLACK)
		{
			Mod.setColor(width, height - 1, Color.WHITE);
			Mod.setColor(width, height, Color.BLACK);
			height--;
		}
		else if(direction == Direction.SOUTH  && height < Mod.getHeight() && Mod.getColor(width,  height + 1) == Color.BLACK)
		{
			Mod.setColor(width, height + 1, Color.WHITE);
			Mod.setColor(width, height, Color.BLACK);
			height++;
		}
		else if(direction == Direction.EAST && width < Mod.getWidth() && Mod.getColor(width + 1,  height) == Color.BLACK)
		{
			Mod.setColor(width + 1, height, Color.WHITE);
			Mod.setColor(width, height, Color.BLACK);
			width++;
		}
		else if(direction == Direction.WEST && width > 0 && Mod.getColor(width - 1,  height) == Color.BLACK)
		{
			Mod.setColor(width - 1, height, Color.WHITE);
			Mod.setColor(width, height, Color.BLACK);
			width--;
		}
	}
}
