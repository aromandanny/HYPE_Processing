/*
 * HYPE_Processing
 * http://www.hypeframework.org/ & https://github.com/hype/HYPE_Processing
 * 
 * Copyright (c) 2013 Joshua Davis & James Cruz
 * 
 * Distributed under the BSD License. See LICENSE.txt for details.
 * 
 * All rights reserved.
 */

package hype;

import hype.core.util.H;
import hype.core.util.HMath;
import hype.extended.drawable.HPathNEW;
import processing.core.PApplet;

/**
 * @mainpage
 * Welcome to the HYPE_processing documentation! The library itself is currently
 * under construction, so naturally, the documentation is far from complete yet.
 * 
 * @cond FALSE
 */
public class DummyApplet extends PApplet {
	private static final long serialVersionUID = 1L;
	
	/* TODO
	 * (HPath)
	 * - [ ] fix HVertexNEW and HPathNEW's hitbox
	 * - [ ] HPathNEW.line(x,y,x,y);
	 * - [ ] draw handles
	 * 
	 * (HDrawable)
	 * - [ ] HDrawable.stylesChildren(bool)
	 * 		- stroke
	 * 		- stroke weight
	 * 		- stroke join
	 * 		- stroke cap
	 * 		- fill
	 * - [ ] HDrawable.rotatesChildren(bool)
	 * - [ ] apply the UV coordinate stuff
	 * - [ ] remove casting reqs for add() / remove()
	 * 
	 * (HBehavior)
	 * - [ ] boolean params for HBehavior constructors (default=true,
	 *       true - register, false - don't register)
	 * - [ ] HTween: start/end 1/2/3 getters
	 * - [ ] HTween: delegate start() & end() methods to start(a,b,c) &
	 *       start(a,b,c)
	 * - [ ] new HBehavior(isRegistered) + isRegistered constructors for other
	 *       behaviors
	 * - [ ] HTween & HOscillator: store the scale factor when using H.SCALE
	 *       instead of the multiplied sizes; just compute the "multiplier" in
	 *       runBehavior() to multiply the curent values (in this case, width
	 *       and height)
	 * - [ ] remove `registered()`
	 * - [ ] abstract `HBehavior.createCopy()`
	 * 
	 * (HShape)
	 * - [ ] HShape hit detection + pgraphics buffer
	 * - [ ] disable style for HShape in P3D
	 * 
	 * (HText)
	 * - [ ] click buffer for HText
	 * - [ ] textbox mode for HText
	 * - [ ] use onResize() when adjusting metrics
	 * 
	 * (HCallback NOP)
	 * - HConstants.NOP (an empty HCallback that does nothing, to be used as
	 *   sentinel; test this on JS mode)
	 * - HDrawablePool
	 * 		- Replace HCallback null checks with NOP
	 * 		- if onCreate/Request/Release(null), then assign NOP
	 * 		- privatize _onCreate/Request/Release
	 * - HTriggers & HTween
	 * 		- Replace HCallback null checks with NOP
	 * 		- if callback(null), then assign NOP
	 * 
	 * (HRect)
	 * - [ ] rounding() getter (returns _tl)
	 * - [ ] privatize _tl/_tr/_br/_bl fields
	 * 
	 * 
	 * (Experiments and New Features)
	 * - [ ] store HDrawable coordinates as UV
	 * - [ ] new interface: HImageHolder
	 * 		- interface methods: image(Object imgArg), image()
	 * 		- H.extractImage(Object imgArg)
	 * 			- if arg is PImage: use the image
	 * 			- if arg is HImageHolder: call image()
	 * 			- if arg is String: load file
	 * 			- else: return null
	 * 		- implement this to HImage and HPixelColorist and HStage (for img bg)
	 * 		- apply when setting images
	 * - [ ] masking
	 * - [ ] wipfile: Proximity
	 * - [ ] wipfile: Adjuster
	 * 		- drawable.adjuster(true)
	 * 		- del key = remove from parent
	 * - [ ] DepthShuffle
	 * - [ ] HVelocity testfiles (check AS3::SimpleBallistic)
	 * - [ ] AS3::Vibration
	 * - [ ] H.capture()
	 * 		- capture() -- current frame
	 * 		- capture(1) -- single frame
	 * 		- capture(1,10) -- frame sequence
	 * 		- pdf frames (remember that individual pdf frames ignores autoClear(false))
	 * 
	 * (Future Refactors)
	 * - [ ] property setter objects
	 * - [ ] have HColors implement HConstants
	 * - [ ] have HDrawable perc stuff use x2y()/y2v()/u2x()/v2y()
	 * - [ ] rename xxxPerc -> xxxUV or xxxPc
	 * - [ ] rearrange HDrawable's fields by category instead of type
	 * - [ ] HMath: add z index for abs/relLoc()
	 * - [ ] HMath: use processing's random() instead of java.lang.Math
	 * - [ ] change util methods that returns arrays to use the method(val, float[] loc) format
	 * - [ ] privatize remaining public fields
	 * - [ ] color mask constants
	 * - [ ] HColors.invisible(int) -- use color masks `(clr & maskAlpha) == 0`
	 * - [ ] more consistent boolean getter names
	 * 
	 * (Code Standards)
	 * - [ ] standardize single param names
	 * - [ ] standardize newlines
	 * 		- newline before & after the class' closing brackets
	 * 		- ???
	 * 
	 * (Optimization)
	 * - [ ] use bitflags for multiple bools
	 * - [ ] use byte for small ints
	 * 
	 * (Docs)
	 * - [ ] use full sentence format with @param and @return statements
	 * - [ ] use multiple @see tags
	 * - [ ] use a single line break for doc summaries if they're too long
	 * 
	 * (Far Future Stuff)
	 * - [ ] HContext overhaul
	 * - [ ] FSM java to pde parser
	 * - [ ] HYPE Coding Standards documentation for devs
	 * - [ ] HTML Page for the Documentation
	 * - [ ] AS3::SoundAnalyzer
	 */
	
	HPathNEW path;
	
	@Override
	public void setup() {
		size(300,300);
		H.init(this);
		H.background(H.BLUE);
		
		path = (HPathNEW) H.add(new HPathNEW(POLYGON))
			.strokeWeight(1)
			.stroke(H.WHITE)
			.fill(H.CYAN)
			.locAt(H.CENTER)
			.anchorAt(H.CENTER);
//		path
//			.vertexUV(.5f,.5f,  -.5f,.5f, 0,0)
//			.vertexUV(.5f,.5f, .5f,-.5f, 1,0)
//			.vertexUV(.5f,.5f,  1.5f,.5f, 1,1)
//			.vertexUV(.5f,.5f, .5f,1.5f, 0,1)
		
//			.vertexUV(-.5f,.5f, 0,0)
//			.vertexUV(.5f,-.5f, 1,0)
//			.vertexUV(1.5f,.5f, 1,1)
//			.vertexUV(.5f,1.5f, 0,1)
		;
//		path.polygon(6);
		
		int maxi = HMath.randomInt(3,15);
		for(int i=0; i<maxi; ++i) {
			if(HMath.randomInt(2) == 0) {
				path.vertexUV(random(-.5f,1.5f),random(-.5f,1.5f));
			} else if(HMath.randomInt(2) == 0) {
				path.vertexUV(random(-.5f,1.5f),random(-.5f,1.5f),random(-.5f,1.5f),random(-.5f,1.5f));
			} else {
				path.vertexUV(random(-.5f,1.5f),random(-.5f,1.5f),random(-.5f,1.5f),random(-.5f,1.5f),random(-.5f,1.5f),random(-.5f,1.5f));
			}
		}
		
//		H.add(new HRect()).anchorAt(H.CENTER).locAt(H.CENTER).noFill();
		
		H.drawStage();
		stroke(H.RED,128);
		for(int y=0; y<width; ++y) for(int x=0; x<height; ++x) {
			if(path.contains(x,y)) point(x,y);
		}
		noLoop();
	}
}
/** @endcond */