import { Controller, Post, Body, Get, Param } from '@nestjs/common';
import { ConnectionService } from '../services/connection.service';

@Controller('connect')
export class ConnectController {
  constructor(private readonly conn: ConnectionService){}

  @Post('start')
  async start(@Body('provider') provider: string){
    return await this.conn.startAuth(provider, 'user-123');
  }

  @Get('status/:sessionId')
  async status(@Param('sessionId') sessionId: string){
    return this.conn.getStatus(sessionId);
  }
}
