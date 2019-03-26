package com.vk

sealed trait Instruction

object Instruction {

  case object Forward extends Instruction

  case class ForwardBy(steps: Int) extends Instruction

  case object RotateClockwise extends Instruction

  case object RotateAntiClockwise extends Instruction

  def getInstructions(r: Rover, i: Instruction): Rover =
    i match {

      case Instruction.Forward =>
        Rover.moveForward(r)
        Rover(r.coordinates, r.direction)

      case Instruction.ForwardBy(steps) =>
        Rover.moveForwardBy(r, steps)
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
