package com.vk

object Rover extends App {

  case class Coordinates(
      x: Int,
      y: Int
  )

  case class Direction(
      facing: String,
  )

  case class Position(
      coordinates: Coordinates,
      direction: Direction
  )

  def getInstructions(p: Position, instruction: String): Position = {
    instruction match {

      case "f" =>
        moveForward(16, p)
        p

      case "rc" =>
        rotateClockwise(p)
        p

      case "rac" =>
        rotateAntiClockwise(p)
        p

      case _ =>
        getInstructions(p, instruction)
    }
  }

  def moveForward(steps: Int, p: Position): Position = {

    val gridMax = 10

    steps match {

      case num =>
        if (p.direction == Direction("n")) {

          if (num <= 10) {

            val newCoordinates = Coordinates(0, num)
            val newPosition = Position(newCoordinates, p.direction)
            newPosition
          } else {

            val newCoordinates = Coordinates(0, num - gridMax)
            val newPosition = Position(newCoordinates, p.direction)
            newPosition
          }

        } else if (p.direction == Direction("s")) {

          if (num <= 10) {

            val newCoordinates = Coordinates(0, -num)
            val newPosition = Position(newCoordinates, p.direction)
            newPosition
          } else {

            val newCoordinates = Coordinates(0, num - gridMax)
            val newPosition = Position(newCoordinates, p.direction)
            newPosition
          }

        } else if (p.direction == Direction("w")) {

          if (num <= 10) {

            val newCoordinates = Coordinates(-num, 0)
            val newPosition = Position(newCoordinates, p.direction)
            newPosition
          } else {

            val newCoordinates = Coordinates(num - gridMax, 0)
            val newPosition = Position(newCoordinates, p.direction)
            newPosition
          }

        } else if (p.direction == Direction("e")) {

          if (num <= 10) {

            val newCoordinates = Coordinates(num, 0)
            val newPosition = Position(newCoordinates, p.direction)
            newPosition
          } else {

            val newCoordinates = Coordinates(num - gridMax, 0)
            val newPosition = Position(newCoordinates, p.direction)
            newPosition
          }
        } else {

          moveForward(steps, p)
        }

      case _ =>
        moveForward(steps, p)
    }

  }

  def rotateClockwise(p: Position): Position = {

    p.direction match {

      case Direction("n") =>
        val newPosition = Position(Coordinates(0, 0), Direction("e"))
        newPosition

      case Direction("e") =>
        val newPosition = Position(Coordinates(0, 0), Direction("s"))
        newPosition

      case Direction("s") =>
        val newPosition = Position(Coordinates(0, 0), Direction("w"))
        newPosition

      case Direction("w") =>
        val newPosition = Position(Coordinates(0, 0), Direction("n"))
        newPosition

      case _ =>
        rotateClockwise(p)
    }

  }

  def rotateAntiClockwise(p: Position): Position = {

    p.direction match {

      case Direction("n") =>
        val newPosition = Position(Coordinates(0, 0), Direction("w"))
        newPosition

      case Direction("w") =>
        val newPosition = Position(Coordinates(0, 0), Direction("s"))
        newPosition

      case Direction("s") =>
        val newPosition = Position(Coordinates(0, 0), Direction("e"))
        newPosition

      case Direction("e") =>
        val newPosition = Position(Coordinates(0, 0), Direction("n"))
        newPosition

      case _ =>
        rotateAntiClockwise(p)

    }
  }

  getInstructions(Position(Coordinates(0, 0), Direction("w")), "f")
}
