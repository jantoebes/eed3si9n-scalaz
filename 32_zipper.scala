Stream(1, 2, 3, 4).toZipper >>= {_.next} println

Stream(1, 2, 3, 4).toZipper >>= {_.next} >>= {_.next} >>= {_.previous} println

Stream(1, 2, 3, 4).toZipper >>= {_.next} >>= {_.next} >>= {_.modify {_ => 7}.some}
