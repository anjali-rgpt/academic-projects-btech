grammar expression;

equation returns [Integer value]
: e = exp {$value=$e.value; System.out.println("Syntactically correct and evaluated expression is "+$value);};

exp returns [Integer value]
: e1=exp (PLUS) e2=term {$value=$e1.value+$e2.value;}
|e1=exp (MINUS) e2=term {$value=$e1.value-$e2.value;}
| t=term {$value = $t.value;};

term returns [Integer value]
: t=term (TIMES) f=factor {$value=$t.value * $f.value;}
| t=term (DIV) f=factor {$value=$t.value/$f.value;}
| f=factor {$value=$f.value;};

factor returns [Integer value]
: LPAREN e=exp RPAREN {$value = $e.value;}
| NUM {$value=Integer.parseInt($NUM.text);};



LPAREN
: '(';

RPAREN
:')';

PLUS:
'+';

MINUS:
'-';

TIMES:
'*';

DIV:
'/';

NUM:[0-9][0-9]*;

WS:[ \r\n\t] ->skip;
