import scala.io.StdIn

object Encryptor {
  def even_bit(s: String): Char = if (s.count(_ == '1') % 2 == 0) '0' else '1'

  def encrypt_string(s: String): String = {
    val res = s.map(c =>
      val bit_number = Integer.toBinaryString(c.toByte) match
        case b if b.length < 7 => "0" * (7 - b.length) ++ b
        case b => b
      even_bit(bit_number) + bit_number
    )
    res.mkString
  }

  def decrypt_string(s: String): Either[String, String] = {
    if (s.length % 8 != 0) Left("Кол-во битов не кратно 8")
    else if (s.isEmpty) Left("Строка пустая")
    else if (!s.forall(c => c == '0' || c == '1')) Left("Строка содержит символы отличные от 0 и 1")
    else
      val array = s.grouped(8).toArray
      array.find(c => c.head != even_bit(c.tail)) match
        case Some(value) => Left(s"Проверка чётности не пройдена: $value")
        case _ => Right(array.map(_.tail).map(Integer.parseInt(_, 2)).map(_.toChar).mkString)
  }
}


object ParityBit extends App {
  while (true)
    val input_word = StdIn.readLine("Введите слово:")
    val mode = StdIn.readLine("en - зашифровать | dec - дешифровать:")

    mode match
      case "en" => println(s"Зашифрованное  слово: ${Encryptor.encrypt_string(input_word)}")
      case _ => Encryptor.decrypt_string(input_word) match
        case Left(err) => println(s"Ошибка при дешифровки: $err")
        case Right(result) => println(s"Результат дешифровки: $result")

}