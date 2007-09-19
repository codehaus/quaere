package org.quaere.quaere4objects;

import org.quaere.expressions.Expression;
import org.quaere.dsl.parser.QuaereLexer;
import org.quaere.dsl.parser.QuaereParser;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

class LiteralExpressionParser {
    static Expression parseLiteralExpression(String literalExpression) {
        QuaereLexer lexer = new QuaereLexer(new ANTLRStringStream(literalExpression));
        QuaereParser parser = new QuaereParser(new CommonTokenStream(lexer));
        Expression expression;
        try {
            expression = parser.quaereExpression().value;
        } catch (RecognitionException e) {
            throw new RuntimeException(e);
        }
        return expression;
    }
}
