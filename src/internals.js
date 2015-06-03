Kotlin.forEachField = function(o, block) {
  if (o != null && o != undefined) {
    var pair, fieldName;

    if (Object.keys) {
      var fields = Object.keys(o);
      var i, m = fields.length;

      for (i = 0; i < m; ++i) {
        fieldName = fields[i];
        pair = new Kotlin.modules['stdlib'].kotlin.Pair(fieldName, o[fieldName]);
        block.call(o, pair);
      }
    } else {
      for (fieldName in o) {
        if (o.hasOwnProperty(v)) {
          pair = new Kotlin.modules['stdlib'].kotlin.Pair(v, o[v]);
          block.call(o, pair);
        }
      }
    }
  }
};
