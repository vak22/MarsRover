package com.vk

import com.vk.Instruction.{Forward, RotateAntiClockwise, RotateClockwise}
import org.scalatest.{FunSpec, Matchers}

class InstructionSpec extends FunSpec with Matchers {

  describe("should take instruction") {

    it("should take instruction of RotateClockwise") {

      val instruction = RotateClockwise

      instruction shouldEqual Instruction.RotateClockwise

    }

    it("should take instruction of RotateAntiClockwise") {

      val instruction = RotateAntiClockwise

      instruction shouldEqual Instruction.RotateAntiClockwise

    }

    it("should take instruction of Forward") {

      val instruction = Forward

      instruction shouldEqual Instruction.Forward

    }
  }
}
