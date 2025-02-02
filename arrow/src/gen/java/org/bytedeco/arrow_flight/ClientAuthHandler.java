// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow_flight;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.arrow_flight.*;


/** \brief An authentication implementation for a Flight service.
 *  Authentication includes both an initial negotiation and a per-call
 *  token validation. Implementations may choose to use either or both
 *  mechanisms. */
@Namespace("arrow::flight") @Properties(inherit = org.bytedeco.arrow.presets.arrow_flight.class)
public class ClientAuthHandler extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ClientAuthHandler(Pointer p) { super(p); }

  /** \brief Authenticate the client on initial connection. The client
   *  can send messages to/read responses from the server at any time.
   *  @return Status OK if authenticated successfully */
  public native @ByVal Status Authenticate(ClientAuthSender outgoing, ClientAuthReader incoming);
  /** \brief Get a per-call token.
   *  @param token [out] The token to send to the server. */
  public native @ByVal Status GetToken(@StdString @Cast({"char*", "std::string*"}) BytePointer token);
}
