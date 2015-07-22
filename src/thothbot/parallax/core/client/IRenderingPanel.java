package thothbot.parallax.core.client;

import thothbot.parallax.core.client.context.Canvas3d;
import thothbot.parallax.core.client.renderers.WebGLRenderer;

public interface IRenderingPanel {

	public abstract Canvas3d getCanvas();
	public abstract WebGLRenderer getRenderer();

}