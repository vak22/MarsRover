package com.vk

sealed trait HighLevel {
  def toInstructions(d: Direction): List[Instruction] =
    HighLevel.toInstructions(this, d)
}

object HighLevel {

  case class ForwardBy(steps: Int) extends HighLevel

  case object TurnNorth extends HighLevel

  case object TurnEast extends HighLevel

  case object TurnSouth extends HighLevel

  case object TurnWest extends HighLevel

  def toInstructions(hl: HighLevel, d: Direction): List[Instruction] =
    hl match {
      case HighLevel.ForwardBy(steps) =>
        Instruction.forwardStepsToList(steps)

      case HighLevel.TurnNorth =>
        Instruction.toDirection(Direction.North, d)

      case HighLevel.TurnEast =>
        Instruction.toDirection(Direction.East, d)

      case HighLevel.TurnSouth =>
        Instruction.toDirection(Direction.South, d)

      case HighLevel.TurnWest =>
        Instruction.toDirection(Direction.West, d)

      case _ =>
        Nil
    }
}

sealed trait Rotation
object Rotation {
  case object Clockwise extends Rotation
  case object AntiClockwise extends Rotation
}

sealed trait Instruction

object Instruction {

  case object Forward extends Instruction

  case object RotateClockwise extends Instruction

  case object RotateAntiClockwise extends Instruction

  def forwardStepsToList: Int => List[Instruction] =
    steps => (1 to steps).toList.map(_ => Instruction.Forward)

  def toDirection(target: Direction, current: Direction): List[Instruction] = {
    def toDirectionRec(
        target: Direction,
        current: Direction,
        instructions: List[Instruction],
        defaultRotation: Rotation = Rotation.Clockwise): List[Instruction] =
      (target, current, defaultRotation) match {
        case (t, c, _) if t == c =>
          instructions

        case (t, c, Rotation.Clockwise) =>
          toDirectionRec(t,
                         Direction.rotateClockwise(c),
                         instructions :+ Instruction.RotateClockwise)

        case (t, c, Rotation.AntiClockwise) =>
          toDirectionRec(t,
                         Direction.rotateAntiClockwise(c),
                         instructions :+ Instruction.RotateAntiClockwise)
      }
    val initialInstructions = toDirectionRec(target, current, Nil)

    if (initialInstructions.length == 3)
      toDirectionRec(target, current, Nil, Rotation.AntiClockwise)
    else initialInstructions
  }

  def executeInstructionList(r: Rover, i: List[Instruction]): Rover =
    i.foldLeft(r)((r1, i1) => executeInstructions(r1, i1))

  def executeInstructions(r: Rover, i: Instruction): Rover =
    i match {

      case Forward =>
        Rover.moveForward(r)

      case RotateClockwise =>
        Rover(r.coordinates, Direction.rotateClockwise(r.direction))

      case RotateAntiClockwise =>
        Rover(r.coordinates, Direction.rotateAntiClockwise(r.direction))

      case _ =>
        r
    }
}
