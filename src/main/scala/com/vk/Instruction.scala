package com.vk

sealed trait Instruction

object Instruction {

  case object Forward extends Instruction

  case object RotateClockwise extends Instruction

  case object RotateAntiClockwise extends Instruction

  def getInstructions(r: Rover, i: Instruction): Rover =
    i match {

      case Instruction.Forward =>
        Rover.moveForwardBy(r, 12)
        Rover(r.coordinates, r.direction)

      case Instruction.RotateClockwise =>
        Direction.rotateClockwise(r.direction)
        Rover(r.coordinates, r.direction)

      case Instruction.RotateAntiClockwise =>
        Direction.rotateAntiClockwise(r.direction)
        Rover(r.coordinates, r.direction)

      case _ =>
        getInstructions(r, i)
    }

}
