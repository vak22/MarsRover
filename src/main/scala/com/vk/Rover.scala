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

  case class Grid(
      maxX: Int = 10,
      maxY: Int = 10
  )

  def getInstructions(p: Position, instruction: String): Position = {

    instruction match {

      case "forward" =>
        moveForward(1, p)
        p

      case "rotate clockwise" =>
        rotateClockwise(p)
        p

      case "rotate anticlockwise" =>
        rotateAntiClockwise(p)
        p

      case _ =>
        getInstructions(p,instruction)
    }
  }

  def moveForward(steps: Int, p: Position): Position = {

    steps match {

      case 1 =>
        val newCoordinates = Coordinates(1, 0)
        val newPosition = Position(newCoordinates, p.direction)
        newPosition

      case _ =>
        moveForward(steps,p)

    }

  }

  def rotateClockwise(p: Position): Position = {

    p.direction match {

      case Direction("North") =>
        val newPosition = Position(Coordinates(0, 0), Direction("East"))
        newPosition

      case Direction("East") =>
        val newPosition = Position(Coordinates(0, 0), Direction("South"))
        newPosition

      case Direction("South") =>
        val newPosition = Position(Coordinates(0, 0), Direction("West"))
        newPosition

      case Direction("West") =>
        val newPosition = Position(Coordinates(0, 0), Direction("North"))
        newPosition

      case _ =>
        rotateClockwise(p)
    }

  }

  def rotateAntiClockwise(p: Position): Position = {

    p.direction match {

      case Direction("North") =>
        val newPosition = Position(Coordinates(0, 0), Direction("West"))
        newPosition

      case Direction("West") =>
        val newPosition = Position(Coordinates(0, 0), Direction("South"))
        newPosition

      case Direction("South") =>
        val newPosition = Position(Coordinates(0, 0), Direction("East"))
        newPosition

      case Direction("East") =>
        val newPosition = Position(Coordinates(0, 0), Direction("North"))
        newPosition

      case _ =>
      rotateAntiClockwise(p)

    }
  }

  getInstructions(Position(Coordinates(0, 0), Direction("North")), "rotate clockwise")
}
