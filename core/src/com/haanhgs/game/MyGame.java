package com.haanhgs.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class MyGame extends ApplicationAdapter {

	public interface OpenAlert {
		void openAlert();
	}

	private OrthographicCamera cam;
	private Vector2 position;
	private ShapeRenderer renderer;
	private static float width;
	private static float height;
	private OpenAlert listener;
	private boolean isRunning = true;

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public void setListener(OpenAlert listener) {
		this.listener = listener;
	}

	@Override
	public void create () {
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, width, height);
		position = new Vector2(width/20,height - width/20);
		renderer = new ShapeRenderer();
	}

	@Override
	public void render () {
		if (Gdx.input.justTouched()){
			isRunning = false;
	   		listener.openAlert();
		}

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		cam.update();

		if (isRunning){
            if (position.y >= width/20 && position.x == width/20) {
                position.y -= 10;
            }else if (position.y <= width/20 && position.x <= width - width/20){
                position.x += 10;
            }else if (position.x >= width - width/20 && position.y <= height - width/20){
                position.y += 10;
            }else if (position.y >= height -width/20 && position.x >= width/20){
                position.x -= 10;
            }
        }

		renderer.begin(ShapeRenderer.ShapeType.Filled);
		renderer.setColor(Color.RED);
		renderer.circle(position.x, position.y, width/20);
		renderer.end();
	}
	
	@Override
	public void dispose () {
		renderer.dispose();
	}

	@Override
	public void pause() {
		super.pause();
		isRunning = false;
	}

	@Override
	public void resume() {
		super.resume();
		isRunning = true;
	}
}
