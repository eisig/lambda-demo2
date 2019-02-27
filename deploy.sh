
S3_PREFIX="${S3_PREFIX:-serverless}"

sam package --s3-bucket $S3_BUCKET --s3-prefix $S3_PREFIX \
  --template-file template.yaml --output-template-file target/packaged.yaml

aws cloudformation deploy --template-file target/packaged.yaml --stack-name my-app2 --capabilities CAPABILITY_IAM