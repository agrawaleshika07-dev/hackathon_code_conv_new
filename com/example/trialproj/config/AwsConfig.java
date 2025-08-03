package com.example.trialproj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class AwsConfig {

    @Value("${aws.region}")
    private String awsRegion;

    @Bean
    public Ec2Client ec2Client() {
        return Ec2Client.builder().region(Region.of(awsRegion)).credentialsProvider(DefaultCredentialsProvider.create()).build();
    }

    @Bean
    public S3Client s3Client() {
        return S3Client.builder().region(Region.of(awsRegion)).credentialsProvider(DefaultCredentialsProvider.create()).build();
    }

    @Bean
    public SqsClient sqsClient() {
        return SqsClient.builder().region(Region.of(awsRegion)).credentialsProvider(DefaultCredentialsProvider.create()).build();
    }

    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder().region(Region.of(awsRegion)).credentialsProvider(DefaultCredentialsProvider.create()).build();
    }
}

