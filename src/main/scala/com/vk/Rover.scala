package com.vk

//import scala.io.StdIn.readLine

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
        rotateClockwise(Direction("East"))
        p

      case "rotate anticlockwise" =>
        rotateAntiClockwise(Direction("West"))
        p

      case _ =>
        //What do here?
        p
    }
  }

  def moveForward(steps: Int, p: Position): Position = {

    steps match {

      case 1 =>
        val newCoordinates = Coordinates(1, 0)
        val newPosition = Position(newCoordinates, p.direction)
        println(newPosition)
        newPosition

      case _ =>
        //What do here?
        p

    }

  }

  def rotateClockwise(d: Direction): Direction = {

    d.facing match {

      case "North" =>
        val newDirection = Direction("East")
        newDirection

      case "East" =>
        val newDirection = Direction("South")
        newDirection

      case "South" =>
        val newDirection = Direction("West")
        newDirection

      case "West" =>
        val newDirection = Direction("North")
        newDirection

      case _ =>
        //What do here?
        rotateClockwise(d)
    }

  }

  def rotateAntiClockwise(d: Direction): Direction = {

    d.facing match {

      case "North" =>
        val newDirection = Direction("West")
        newDirection

      case "West" =>
        val newDirection = Direction("South")
        newDirection

      case "South" =>
        val newDirection = Direction("East")
        newDirection

      case "East" =>
        val newDirection = Direction("North")
        newDirection

      case _ =>
        //What do here?
        d
    }
  }

  getInstructions(Position(Coordinates(0, 0), Direction("North")), "forward")
}
