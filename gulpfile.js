var gulp = require('gulp');
var responsive = require('gulp-responsive');

gulp.task('default', function () {
  return gulp.src('img/team/*.{png,jpg}')
    .pipe(responsive({
      '*.jpg': [{
        // image-small.jpg is 200 pixels wide
        width: 200,
        rename: {
          suffix: '-sm',
          extname: '.jpg'
        }
      }, {
        // image-small@2x.jpg is 400 pixels wide
        width: 200 * 2,
        rename: {
          suffix: '-sm@2x',
          extname: '.jpg'
        }
      }, {
        // image-large.jpg is 480 pixels wide
        width: 480,
        rename: {
          suffix: '-lg',
          extname: '.jpg'
        }
      }, {
        // image-large@2x.jpg is 960 pixels wide
        width: 480 * 2,
        rename: {
          suffix: '-lg@2x',
          extname: '.jpg'
        }
      }, {
        // image-extralarge.jpg is 1280 pixels wide
        width: 1280,
        rename: {
          suffix: '-xl',
          extname: '.jpg'
        }
      }, {
        // image-extralarge@2x.jpg is 2560 pixels wide
        width: 1280 * 2,
        rename: {
          suffix: '-xl',
          extname: '.jpg'
        }
      }]
    }))
    .pipe(gulp.dest('dist'));
});
