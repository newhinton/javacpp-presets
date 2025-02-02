// Targeted by JavaCPP version 1.5.6: DO NOT EDIT THIS FILE

package org.bytedeco.ale;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.ale.global.ale.*;


@NoOffset @Properties(inherit = org.bytedeco.ale.presets.ale.class)
public class DisplayScreen extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DisplayScreen(Pointer p) { super(p); }

    public DisplayScreen(MediaSource mediaSource, Sound sound, @ByRef ColourPalette palette) { super((Pointer)null); allocate(mediaSource, sound, palette); }
    private native void allocate(MediaSource mediaSource, Sound sound, @ByRef ColourPalette palette);

    // Displays the current frame buffer from the mediasource.
    public native void display_screen();

    // Has the user engaged manual control mode?
    public native @Cast("bool") boolean manual_control_engaged();

    // Captures the keypress of a user in manual control mode.
    public native @Cast("Action") int getUserAction();
}
