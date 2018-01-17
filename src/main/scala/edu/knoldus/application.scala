package edu.knoldus

import org.apache.log4j.Logger

object Payment {

  def main(args: Array[String]): Unit = {
    val log = Logger.getLogger(this.getClass)
    val amount = 500
    val paymentMethod = "paytm/freecharge"
    val process = new Payment
    log.info("Amount paid to tiffin service provide\n")
    log.info(process.amountPaid(amount, paymentMethod))
    val person = new PersonTask
    log.info("\n" + person.findTaskPerformed(Trainer()))
    log.info("\n" + person.findTaskPerformed(Blogger()))
    log.info("\n" + person.findTaskPerformed(Gamer()))
  }

}

class Payment {

  def amountPaid(amount: Double, paymentMethod: String): Double = {
    paymentMethod.toLowerCase match {
      case "paytm/freecharge" => amount + (amount * (0.02))
      case "net banking" => amount + 5
      case "card payment" => amount + 1.5
      case "cash payment" => amount
      case _ => -1
    }
  }

}


