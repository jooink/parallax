/*
 * Copyright 2012 Alex Usachev, thothbot@gmail.com
 * 
 * This file is part of Parallax project.
 * 
 * Parallax is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU General Public License as published by the 
 * Free Software Foundation, either version 3 of the License, or (at your 
 * option) any later version.
 * 
 * Parallax is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License 
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along with 
 * Parallax. If not, see http://www.gnu.org/licenses/.
 */

package thothbot.parallax.core.shared.lights;

import java.util.List;
import java.util.Map;

import thothbot.parallax.core.client.shaders.Uniform;
import thothbot.parallax.core.shared.Log;
import thothbot.parallax.core.shared.scene.Scene;

/**
 * Lights used in the {@link Scene}.
 * 
 * @author thothbot
 *
 */
public class RendererLights
{
	AmbientLight.UniformAmbient ambient;
	DirectionalLight.UniformDirectional directional;
	PointLight.UniformPoint point;
	SpotLight.UniformSport spot;
	HemisphereLight.UniformHemisphere hemi;
	
	public RendererLights() 
	{
		ambient = new AmbientLight.UniformAmbient();
		directional = new DirectionalLight.UniformDirectional();
		point = new PointLight.UniformPoint();
		spot = new SpotLight.UniformSport();
		hemi = new HemisphereLight.UniformHemisphere();
	}
				
	public void setupLights ( List<Light> lights, boolean  isGammaInput) 
	{
		Log.debug("Called setupLights()");
		
		// Reset uniforms
		ambient.reset();
		directional.reset();
		point.reset();
		spot.reset();
		hemi.reset();
		
		for ( Light light: lights) 
		{
			if ( light.isOnlyShadow() || ! light.isVisible()) 
				continue;

			light.setupRendererLights(this, isGammaInput);
		}
	}
	
	public void refreshUniformsLights ( Map<String, Uniform> uniforms ) 
	{
		ambient.refreshUniform(uniforms);
		directional.refreshUniform(uniforms);
		point.refreshUniform(uniforms);
		spot.refreshUniform(uniforms);
		hemi.refreshUniform(uniforms);
	}
}
