### Java HTTP/1.1 Server Microsteps

Phase 0: Setup
- [ ] Create a new Java project.
- [ ] Create a main class, e.g., `MyHttpServer.java`.
- [ ] Pick a port for testing (e.g., 8080).

---

Phase 1: TCP Server Basics
1. [ ] Create a `ServerSocket` on your chosen port.
2. [ ] Call `accept()` to wait for a client connection.
3. [ ] Get `InputStream` and `OutputStream` from the client `Socket`.
4. [ ] Read some bytes and print them to the console.
5. [ ] Close the client socket.

**Nudge:** Wrap `InputStream` in `BufferedReader` for easy line reading. Test with `telnet localhost:8080` or `curl -v localhost:8080`.

---

Phase 2: Send a Basic HTTP Response
1. [ ] Use the client `OutputStream` to send a simple HTTP response:
