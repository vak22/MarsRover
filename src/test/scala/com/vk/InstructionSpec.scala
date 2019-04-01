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

  describe("high level instructions") {

    it("should be able to interpret a move forward command") {
      val command = HighLevel.ForwardBy(12)

      val actual: List[Instruction] =
        HighLevel.toInstructions(command, Direction.North)

      actual.length shouldEqual 12

      actual.forall {
        case Instruction.Forward => true
        case _                   => false
      } shouldEqual true

    }

    it("should execute the move forward commands") {
      val rover = Rover(Coordinates(0, 0), Direction.North)

      val command = HighLevel.ForwardBy(3)

      val instructions = HighLevel.toInstructions(command, rover.direction)

      val actual = Instruction.executeInstructionList(rover, instructions)

      val expected = Rover(Coordinates(0, 3), Direction.North)

      actual shouldEqual expected
    }

    it("should execute the rotate clockwise commands") {
      val rover = Rover(Coordinates(0, 0), Direction.North)

      val command = HighLevel.TurnSouth

      val instructions = HighLevel.toInstructions(command, rover.direction)

      val actual = Instruction.executeInstructionList(rover, instructions)

      val expected = Rover(Coordinates(0, 0), Direction.South)

      actual shouldEqual expected
    }

    it("should execute the rotate anticlockwise commands") {
      val rover = Rover(Coordinates(0, 0), Direction.North)

      val command = HighLevel.TurnWest

      val instructions = HighLevel.toInstructions(command, rover.direction)

      val actual = Instruction.executeInstructionList(rover, instructions)

      val expected = Rover(Coordinates(0, 0), Direction.West)

      actual shouldEqual expected
    }

    it("should be an empty list if already in right direction") {
      val rover = Rover(Coordinates(0, 0), Direction.North)

      val command = HighLevel.TurnNorth

      val actual = HighLevel.toInstructions(command, rover.direction)

      val expected = List.empty

      actual shouldEqual expected
    }

  }

  describe("most efficient instructions") {

    it("should turn anti clockwise if facing North and TurnWest requested") {
      val rover = Rover(Coordinates(0, 0), Direction.North)

      val command = HighLevel.TurnWest

      val actual = HighLevel.toInstructions(command, rover.direction)

      val expected = List(RotateAntiClockwise)

      actual shouldEqual expected
    }

    it("should turn clockwise once if facing North and TurnEast requested") {
      val rover = Rover(Coordinates(0, 0), Direction.North)

      val command = HighLevel.TurnEast

      val actual = HighLevel.toInstructions(command, rover.direction)

      val expected = List(RotateClockwise)

      actual shouldEqual expected
    }
  }
}
