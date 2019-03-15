package com.vk

import org.scalatest.{FunSpec, Matchers}

class DirectionSpec extends FunSpec with Matchers {

  describe("rotation") {
    it("should rotate clockwise") {
      val start = Direction.North
      Direction.rotateClockwise(start) shouldEqual Direction.East
    }
  }

}
